// ProjectTwo.cpp
// CS 300 - Project Two: ABCU Advising Assistance Program
// Author: Eddie Loya
//
// This command-line program loads course data from a comma-separated file,
// stores the courses in a hash table, prints an alphanumeric course list,
// and displays a selected course with the titles of its prerequisites.

// Expected input format:
// courseNumber,courseTitle,prerequisite1,prerequisite2,...

// Course numbers and titles are required. A course may have zero or more
// prerequisites. Blank trailing prerequisite columns are ignored.


#include <algorithm>
#include <cctype>
#include <fstream>
#include <iostream>
#include <sstream>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

// Stores one course and the course numbers of its prerequisites.
struct Course {
    string courseNumber;
    string title;
    vector<string> prerequisites;
};

using CourseTable = unordered_map<string, Course>;

// Removes whitespace from both ends of a string.
string trim(const string& text) {
    size_t first = 0;
    while (first < text.size()
           && isspace(static_cast<unsigned char>(text[first]))) {
        ++first;
    }

    size_t last = text.size();
    while (last > first
           && isspace(static_cast<unsigned char>(text[last - 1]))) {
        --last;
    }

    return text.substr(first, last - first);
}

// Normalizes course numbers so searching is not case-sensitive.
string toUpper(string text) {
    transform(text.begin(), text.end(), text.begin(),
              [](unsigned char character) {
                  return static_cast<char>(toupper(character));
              });
    return text;
}

// Parses one CSV row without relying on an external CSV parser. Quoted fields
// and escaped quotation marks are supported in addition to ordinary fields.
bool parseCsvLine(const string& line, vector<string>& fields,
                  string& errorMessage) {
    fields.clear();
    string field;
    bool insideQuotes = false;

    for (size_t i = 0; i < line.size(); ++i) {
        char character = line[i];

        if (character == '"') {
            if (insideQuotes && i + 1 < line.size() && line[i + 1] == '"') {
                field += '"';
                ++i;
            } else {
                insideQuotes = !insideQuotes;
            }
        } else if (character == ',' && !insideQuotes) {
            fields.push_back(trim(field));
            field.clear();
        } else {
            field += character;
        }
    }

    if (insideQuotes) {
        errorMessage = "unmatched quotation mark";
        return false;
    }

    fields.push_back(trim(field));
    return true;
}

// Reads and validates the complete data file before replacing the current
// hash table. This prevents a failed load from leaving partially loaded data.
bool loadCourses(const string& fileName, CourseTable& courses) {
    ifstream inputFile(fileName);
    if (!inputFile.is_open()) {
        cout << "Error: Unable to open the course data file." << endl;
        return false;
    }

    CourseTable loadedCourses;
    string line;
    size_t lineNumber = 0;

    while (getline(inputFile, line)) {
        ++lineNumber;

        // Remove a carriage return when reading a Windows-formatted file.
        if (!line.empty() && line.back() == '\r') {
            line.pop_back();
        }

        if (trim(line).empty()) {
            cout << "Format error on line " << lineNumber
                 << ": line is empty." << endl;
            return false;
        }

        vector<string> fields;
        string parseError;
        if (!parseCsvLine(line, fields, parseError)) {
            cout << "Format error on line " << lineNumber << ": "
                 << parseError << "." << endl;
            return false;
        }

        if (fields.size() < 2 || fields[0].empty() || fields[1].empty()) {
            cout << "Format error on line " << lineNumber
                 << ": a course number and title are required." << endl;
            return false;
        }

        Course course;
        course.courseNumber = toUpper(fields[0]);
        course.title = fields[1];

        if (loadedCourses.find(course.courseNumber) != loadedCourses.end()) {
            cout << "Format error on line " << lineNumber
                 << ": duplicate course number " << course.courseNumber
                 << "." << endl;
            return false;
        }

        unordered_set<string> uniquePrerequisites;
        for (size_t i = 2; i < fields.size(); ++i) {
            // The supplied ABCU file uses empty columns for courses that have
            // fewer prerequisites, so blank prerequisite fields are ignored.
            if (fields[i].empty()) {
                continue;
            }

            string prerequisite = toUpper(fields[i]);
            if (uniquePrerequisites.insert(prerequisite).second) {
                course.prerequisites.push_back(prerequisite);
            }
        }

        loadedCourses.emplace(course.courseNumber, course);
    }

    if (loadedCourses.empty()) {
        cout << "Format error: the file contains no course records." << endl;
        return false;
    }

    // Validate references only after every course has been read. This allows
    // a prerequisite to appear later in the input file.
    for (const auto& entry : loadedCourses) {
        const Course& course = entry.second;
        for (const string& prerequisite : course.prerequisites) {
            if (loadedCourses.find(prerequisite) == loadedCourses.end()) {
                cout << "Format error: prerequisite " << prerequisite
                     << " for " << course.courseNumber
                     << " does not exist in the file." << endl;
                return false;
            }
        }
    }

    courses.swap(loadedCourses);
    cout << courses.size() << " courses loaded successfully." << endl;
    return true;
}

// Prints every course in ascending alphanumeric order by course number.
void printCourseList(const CourseTable& courses) {
    vector<const Course*> sortedCourses;
    sortedCourses.reserve(courses.size());

    for (const auto& entry : courses) {
        sortedCourses.push_back(&entry.second);
    }

    sort(sortedCourses.begin(), sortedCourses.end(),
         [](const Course* first, const Course* second) {
             return first->courseNumber < second->courseNumber;
         });

    cout << endl << "Here is a sample schedule:" << endl;
    for (const Course* course : sortedCourses) {
        cout << course->courseNumber << ", " << course->title << endl;
    }
}

// Looks up and prints one course and the full names of its prerequisites.
void printCourseInformation(const CourseTable& courses,
                            const string& requestedNumber) {
    string courseNumber = toUpper(trim(requestedNumber));
    auto courseIterator = courses.find(courseNumber);

    if (courseIterator == courses.end()) {
        cout << "Course " << courseNumber << " not found." << endl;
        return;
    }

    const Course& course = courseIterator->second;
    cout << endl << course.courseNumber << ", " << course.title << endl;
    cout << "Prerequisites: ";

    if (course.prerequisites.empty()) {
        cout << "None" << endl;
        return;
    }

    for (size_t i = 0; i < course.prerequisites.size(); ++i) {
        const string& prerequisiteNumber = course.prerequisites[i];
        const Course& prerequisite = courses.at(prerequisiteNumber);

        if (i > 0) {
            cout << ", ";
        }
        cout << prerequisite.courseNumber << ", " << prerequisite.title;
    }
    cout << endl;
}

// Converts the entire menu response to an integer and rejects extra text.
bool parseMenuChoice(const string& input, int& choice) {
    istringstream inputStream(input);
    char extraCharacter;

    if (!(inputStream >> choice)) {
        return false;
    }

    return !(inputStream >> extraCharacter);
}

void displayMenu() {
    cout << endl;
    cout << "1. Load Data Structure." << endl;
    cout << "2. Print Course List." << endl;
    cout << "3. Print Course." << endl;
    cout << "9. Exit" << endl;
    cout << endl << "What would you like to do? ";
}

int main() {
    CourseTable courses;
    bool dataLoaded = false;
    string input;

    cout << "Welcome to the course planner." << endl;

    while (true) {
        displayMenu();

        if (!getline(cin, input)) {
            cout << endl << "Thank you for using the course planner!" << endl;
            break;
        }

        int choice = 0;
        if (!parseMenuChoice(input, choice)) {
            cout << input << " is not a valid option." << endl;
            continue;
        }

        if (choice == 1) {
            cout << "What is the name of the file that contains the course data? ";
            string fileName;
            if (!getline(cin, fileName)) {
                cout << endl << "Thank you for using the course planner!" << endl;
                break;
            }

            fileName = trim(fileName);
            if (fileName.empty()) {
                cout << "Error: A file name is required." << endl;
                continue;
            }

            // Keep previously validated data available if a later load fails.
            if (loadCourses(fileName, courses)) {
                dataLoaded = true;
            }
        } else if (choice == 2) {
            if (!dataLoaded) {
                cout << "Please load the course data first." << endl;
            } else {
                printCourseList(courses);
            }
        } else if (choice == 3) {
            if (!dataLoaded) {
                cout << "Please load the course data first." << endl;
            } else {
                cout << "What course do you want to know about? ";
                string courseNumber;
                if (!getline(cin, courseNumber)) {
                    cout << endl << "Thank you for using the course planner!"
                         << endl;
                    break;
                }

                if (trim(courseNumber).empty()) {
                    cout << "Error: A course number is required." << endl;
                } else {
                    printCourseInformation(courses, courseNumber);
                }
            }
        } else if (choice == 9) {
            cout << "Thank you for using the course planner!" << endl;
            break;
        } else {
            cout << choice << " is not a valid option." << endl;
        }
    }

    return 0;
}
