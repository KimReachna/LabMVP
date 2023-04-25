# Введение в программирование для мобильных платформ

Year 3 - Module 2

## Laboratory Work №4 - MVP

**Topic 3.1:** Architectural patterns of MVP, MVVM, the use of the message bus.

**Requirement:**

- Using Android Studio, implement an application based on the MVC architecture (implement a Model class with test data containing an array of 50 objects consisting of first and last names), implement a View, implement a Presenter). Similarly, implement an application based on the MVVM architecture (implement Model, View and ViewModel).

- The logic of the application:

  - at startup, an Activity with Fragment with a built-in RecyclerView is launched, test data (first and last name) are output to the table

  - by clicking on the "Add" button, a form opens for entering a new first and last name. By clicking on the "Save" button, a new entry appears in the table

  - long tap on a table row opens a menu with a suggestion to delete an entry. If the user agrees, the record is deleted from the table.

- All changes should affect the state of the model. You don't need to store the model between app launches.
