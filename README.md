# To Do App
Overview
TODO list app that allows users to manage their tasks while also displaying the current weather information. The app will show the current temperature, as well as the sunrise and sunset times for the day, providing users with helpful context as they plan their activities.

# Tech Stack

- Kotlin
- Jetpack Compose
- Jetpack Navigation
- Jetpack Room
- Hilt
- Retrofit
- Data Store
- Junit

# Requirements

### ToDo List Implementation

- [x] Set-up a project with local data persistence
- [x] Create a basic list view with two sections: "To do", "Completed"
- [x] Implement the ability to add tasks and persist them to the local database
- [x] Each task should have a title, description, and a visual indication if it is completed
- [x] Implement the ability to mark tasks as completed
- [x] Tasks marked as completed should move to the completed section
- [x] Implement the removal of tasks
 

### Weather Implementation

Please make use of the following API that is freely available to use on a basic account: https://www.weatherapi.com/docs/

- [x] Create a generic networking layer so that you can make the associated network calls.
- [x] Create functionality that fetches and shows the Current Temperature in a view
- [x] Create functionality that fetches and shows the sunrise time in a view
- [x] Create functionality that fetches and shows the sunset time in a view
- [x] Weather implementation should ideally use the devices location as part of fetching the data.
 

### User Interface considerations

- [x] Be creative, create the UI and UX you see fit!
- [x] Support light and dark mode
 

Overall Quality Checks

- [x] Support native dynamic text sizing
- [x] Write Unit tests for at least one class.
  
