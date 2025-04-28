
---

# CoinSWatch 📈

[![Made with Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-blueviolet?logo=kotlin&logoColor=white)](https://kotlinlang.org/)  
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-Enabled-brightgreen?logo=android)](https://developer.android.com/jetpack/compose)  
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

---

CoinSWatch is a modern Android app built with **Jetpack Compose** that allows users to:

- View the **top 10 cryptocurrencies** by market cap.
- Explore a **details section** for each crypto, including:
    - Crypto’s description
    - Website link
    - Historical market price data (last 7 days)

---

## 📦 Project Structure

```

CoinSWatch/
├── app/                # Main application module (screens, navigation)
│   ├── details/        # Crypto details screen (description, prices, etc.)
│   ├── CoinSwatchApplication.kt  # Hilt Application class
│   ├── LoggingSetup.kt           # Timber (and Sentry tbd) logger setup
│   ├── MainActivity.kt           # App launcher and container
│   └── NavGraph.kt               # Navigation graph between screens
│
├── data/               # Data module (domain models, network, error handling)
│   ├── DataModule.kt   # Hilt module for providing data dependencies
│   ├── error/          # Error handling system 
│   ├── navigation/     # Navigation routes
│   └── net/            # Networking layer
│
├── designsystem/       # UI styles, components, theming
│   ├── theme/          # Colors, Typography, Shapes
│   ├── composables/    # Custom Compose UI components
│   └── values/         # Custom values for composables
│
├── home/               # Home feature
│   ├── ui/             # Feature ui layer - showing the top 10 crypto list
│   ├── domain/         # Domain models (pure app logic)
│   ├── dto/            # Data Transfer Objects for API
│   ├── repository/      # Repository interface and implementation
│   └── service/         # API service interface
│
├── coindetails/        # Coin Details feature
│   ├── ui/             # Feature ui layer - showing the top 10 crypto list
│   ├── domain/         # Domain models (pure app logic)
│   ├── dto/            # Data Transfer Objects for API
│   ├── repository/      # Repository interface and implementation
│   └── service/         # API service interface
│
└── build.gradle        # Gradle build scripts

```

## 🔀 Navigation Flow

```

[HomeScreen]
     ↓ (on Crypto Click)
[DetailsScreen]
     ↓ (view Description)
[DescriptionScreen]
```

### Flow Description:

- **HomeScreen**:  
  Displays a list of the top 10 cryptocurrencies.  
  ➔ When a crypto is clicked, it navigates to:

- **DetailsScreen**:  
  Shows selected crypto's info (website link, historical price, etc.).  
  ➔ From here, users can open:

- **DescriptionScreen**:  
  Displays an extended description about the cryptocurrency.

---

### ✨ Visual Diagram

```
 ┌─────────────┐
 │ HomeScreen  │
 └─────┬───────┘
       │
    Select Crypto
       │
 ┌─────▼───────┐
 │ DetailsScreen│
 └─────┬───────┘
       │
   View Description
       │
 ┌─────▼──────────┐
 │ DescriptionScreen │
 └─────────────────┘
```

---

### 📚 Navigation Management

- All navigation between these screens is handled via `NavGraph.kt`.
- Using **Hilt** for injecting ViewModels across navigation destinations.
- State is passed via `savedStateHandle` or safe navigation arguments where needed.

---

## 🔧 Built With

- **Jetpack Compose** — Modern UI toolkit
- **Flow** — Reactive Streams
- **Coroutines** — Async operations
- **ThreeTenABP** — Time and date management
- **Hilt** — Dependency injection
- **Kotlin Serialization** — JSON parsing
- **Timber** — Logging
- **Sandwich** — API response handling

---

## 🚀 Features

- **Crypto List Screen**:
    - Top 10 cryptocurrencies displayed with market cap info.
    - Clickable items to access detailed view.

- **Crypto Details Screen**:
    - Display crypto description.
    - External website link.
    - View historical prices over the last week.

- **Modern App Architecture**:
    - Unidirectional data flow (ViewModel → UI).
    - Clean separation of concerns (UI, Data, Design).
    - Error handling with graceful UI fallback.

---

## 🛠 Setup

1. Clone this repository:
   ```bash
   git clone https://github.com/vincenzocostagliola/coinswatch.git
   ```

2. Open in **Android Studio** (Meerkat or newer).

3. Sync Gradle.

4. Run the app!

---

## 📸 Screenshots

*Coming soon... Stay tuned!* 🚀

---

## 🧹 Future Improvements

- Implement crypto favorites/bookmarks.
- Add a search bar to filter crypto by name.
- Dark mode support.
- UI/UX enhancements with animated transitions.

---

## 🧑‍💻 Contributing

Pull requests and suggestions are welcome!  
For major changes, please open an issue first to discuss what you would like to change.

---

## 📝 License

This project is licensed under the MIT License — see the [LICENSE](LICENSE) file for details.

---