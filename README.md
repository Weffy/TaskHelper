# TaskHelper
final project for CMP464 course @Lehman College

chose to work alone for project (wanted to see how much I actually learned).
The app is fairly simple:
TaskDBHelper handles all of the database calls
TaskViewer is just displaying the data we get from the db
TaskHelper handles the onClick's (to add or delete items).

so the flow of the app would go:

TaskViewer (take input) ---> TaskDBHelper (process request, grab data) ---> TaskViewer (display data)
