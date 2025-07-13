# UserApp

UserApp is a modern, Kotlin-based Android application developed by [AliBasboga](https://github.com/AliBasboga). It fetches user data from a remote API and displays it in a sleek, Compose-powered UI. The project leverages Jetpack Compose, Retrofit, and StateFlow for a reactive and up-to-date Android experience.

## Features

- **User List Display:** Fetches user data from a remote JSON API and displays it in a list.
- **Modern UI:** Built with Material 3 and Jetpack Compose for a stylish and dynamic user interface.
- **State Management:** Utilizes StateFlow and ViewModel for reactive and robust state management.
- **API Integration:** Uses Retrofit to retrieve data from a RESTful endpoint.

## Getting Started

1. **Clone the repository:**
   ```sh
   git clone https://github.com/AliBasboga/UserApp.git
   ```
2. **Open with Android Studio.**
3. **Install required SDKs and dependencies.**
4. **Build and run the project.**

## Technologies Used

- **Kotlin**
- **Jetpack Compose**
- **Retrofit**
- **StateFlow**
- **ViewModel**
- **Material 3**

## Architecture & Workflow

- `MainActivity.kt`: The entry point of the app. Fetches and displays the user list.
- `UserViewModel.kt`: Handles fetching users from the API and exposes them via StateFlow.
- `UserAPI.kt`: Retrofit interface for retrieving user data as JSON.
- `User.kt`: Data classes for user, address, and company information.
- `UserLists.kt`: Compose components for rendering the user list.

### User Flow

1. When the app launches, `MainActivity` uses `UserViewModel` to fetch users from the API.
2. The fetched users are provided to the UI via StateFlow.
3. The `UserList` component displays the users in the UI.

## API Information

Data is fetched from:  
`https://raw.githubusercontent.com/atilsamancioglu/UsersJSONPlaceHolder/refs/heads/main/users.json`

## Screenshots

> No screenshots added yet.

## Contributions

Feel free to open an issue or submit a pull request for contributions.

## License

MIT
