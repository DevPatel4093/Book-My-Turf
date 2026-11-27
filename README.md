# BookMyTurf – Sports Turf Discovery & Tournament Platform 🏟️📅⚽🏏🏆

**Discover turfs. Explore tournaments. Get ready to play.**

BookMyTurf is an Android application designed to make sports turf discovery and tournament browsing easier. It brings sports categories, turf exploration, tournament information, and booking-related features together in one application.

A premium dark-mode Android turf booking prototype built with Kotlin, Jetpack Compose, Material 3, Navigation Compose and MVVM. 

The goal is to provide users with a convenient platform to explore sports facilities and discover opportunities to participate in sporting events.

## Run the demo

1. Open this directory in Android Studio.
2. Let Gradle sync and run the `app` configuration on Android 8.0 (API 26) or newer.
3. Tap **Continue with demo user**, or use the labelled admin credentials:
   - `admin@bookmyturf.demo`
   - `Admin@12345`

The default build is deliberately self-contained: turf search, filters, favorites, consecutive slot selection, price calculation, simulated UPI processing, booking creation/cancellation, notifications, analytics, turf/slot management and admin views work without credentials or network access. The payment QR is a visual demo ticket and is explicitly marked non-production.

For phone demos, build `assembleOptimized` and install `app/build/outputs/apk/optimized/app-optimized.apk`. This variant uses the same demo application ID and debug signing key, but enables R8/resource shrinking and bundled startup profiles for substantially lower runtime overhead. Keep the regular debug variant for Android Studio inspection.

## Architecture

- `data/`: domain models, repository contract and observable demo repository.
- `ui/`: app state holder/ViewModel, reusable components, theme and screen modules.
- `firebase/`: deployable starting-point Firestore/Storage rules and indexes.

`BookMyTurfRepository`, `AuthGateway` and `PaymentGateway` are the production seams. Replace the demo repository with Firebase-backed implementations using Authentication, Cloud Firestore, Storage and FCM. Payment order creation and signature verification must run on a trusted backend; do not place gateway secrets or sensitive UPI credentials in the Android client.

Recommended Firestore collections: `users`, `admins`, `turfs`, `sports`, `slots`, `bookings`, `payments`, `reviews`, `favorites`, `coupons`, and `notifications`.

## Firebase setup for production

1. Register the production application ID in Firebase and place `google-services.json` in `app/` (it is gitignored).
2. Add the Google Services plugin and Firebase Android BoM, then Auth, Firestore, Storage, and Messaging dependencies.
3. Implement the gateway/repository interfaces and switch dependency injection away from `DemoBookMyTurfRepository`.
4. Assign the `admin` custom claim only from a trusted backend and deploy the rules in `firebase/`.
5. Use App Check, server-generated payment orders, idempotent webhooks and server-side verification before confirming a booking.
---

## Table of Contents

- [About the Project](#about-the-project)
- [Problem Statement](#problem-statement)
- [Project Objectives](#project-objectives)
- [Features](#features)
- [Application Flow](#application-flow)
- [Application Modules](#application-modules)
- [Technology](#technology)
- [Installation](#installation)
- [Screenshots](#screenshots)
- [Project Structure](#project-structure)
- [Current Limitations](#current-limitations)
- [Future Enhancements](#future-enhancements)
- [Contributors](#contributors)
- [Disclaimer](#disclaimer)

---

## About the Project

Finding suitable sports turfs, exploring available sporting facilities, and discovering local tournaments can involve searching across multiple platforms.

**BookMyTurf** aims to simplify this experience through a centralized Android application where users can explore sports categories, browse turf-related information, discover tournaments, and access booking-related options.

The application is designed around a simple and user-friendly interface, making sports discovery more accessible and convenient.

## Problem Statement

Sports enthusiasts often face difficulties when searching for suitable sports facilities and tournaments. Information about locations, sports categories, event schedules, participation requirements, and booking options may be distributed across different platforms.

This creates an inconvenient and time-consuming experience.

BookMyTurf aims to address this problem by providing a unified platform for sports turf discovery and tournament browsing.

## Project Objectives

- Develop a user-friendly Android application for sports discovery.
- Provide easy navigation across different sports categories.
- Allow users to explore turf-related information.
- Display featured and available tournament information.
- Provide search and filtering options for discovery.
- Organize booking-related and account-related information.
- Create a foundation for future online turf booking and tournament management.

## Features

### 1. Welcome & Authentication
- Application welcome screen.
- Sports-themed interface.
- Google sign-in entry point.

### 2. Home Dashboard
- Sports categories and shortcuts.
- Location selection interface.
- Search entry point.
- Featured tournament highlights.
- Personalized discovery section.

### 3. Sports Discovery
Explore different sports categories, including:

- Cricket
- Football
- Basketball
- Badminton

### 4. Turf Discovery
- Explore turf-related listings.
- Location-oriented discovery.
- Empty-state handling when matching places are unavailable.
- Search and filter entry points.

### 5. Tournament Browsing
- Featured tournament listings.
- Tournament names and venue information.
- Event dates.
- Players per team.
- Maximum team participation.
- Prize pool information.
- Entry fee display where provided.

### 6. User Profile
The profile section provides access to:

- My Bookings
- Saved Turfs
- Payment History
- Notifications
- Help & Support
- Terms & Conditions
- Privacy Policy
- Logout

---

## Application Flow

The general application navigation is organized as follows:

```text
                  START
                    |
                    v
              Welcome Screen
                    |
                    v
             Authentication
                    |
                    v
              Home Dashboard
                    |
          +---------+---------+
          |         |         |
          v         v         v
       Explore   Tournaments Profile
          |         |         |
          v         v         v
      Discover  View Event  Account
       Turfs    Information Options
          |         |
          v         v
      View Turf  Registration
      Information Entry Point
          |
          v
      Booking-Related
         Options
```

The bottom navigation provides access to the main sections:

**Home | Explore | Bookings | Profile**

*Note: The diagram represents the intended navigation flow. Actual completion of authentication, registration, booking and payment transactions depends on the implemented integrations.*

## Application Modules

| Module | Description |
|---|---|
| Welcome Module | Introduces the application and provides an authentication entry point. |
| Home Module | Displays the dashboard, location selection and featured content. |
| Explore Module | Provides sports and turf discovery options. |
| Tournament Module | Displays tournament information and participation details. |
| Search & Filter Module | Provides discovery and filtering entry points. |
| Profile Module | Organizes user account and activity-related options. |
| Navigation Module | Provides access to the application's main sections. |

## Technology

The Android application is built using Android development technologies.

The original development project uses:

- **Platform:** Android
- **Programming Language:** Kotlin
- **UI Framework:** Jetpack Compose
- **Build System:** Gradle
- **Android Development Environment:** Android Studio
- **Authentication / Cloud Integration:** Firebase-related integration is included in the project.

*The exact services and integrations available in the distributed APK may differ from the source project's configured capabilities.*

## Project Structure

The Android source project is organized into application, resources, data, UI, and supporting configuration components.

A simplified conceptual structure is:

```text
Book-My-Turf/
│
├── app/
│   └── src/
│       └── main/
│           ├── java/
│           ├── res/
│           └── AndroidManifest.xml
│
├── assets/
├── docs/
├── firebase/
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
└── README.md
```

The exact folders and source-file extensions depend on the checked-out project version.

## Current Limitations

BookMyTurf is an academic project and demonstration application.

The following capabilities should be considered subject to implementation and testing:

- Live turf availability and real-time slot synchronization.
- Successful end-to-end Google authentication.
- Complete booking confirmation and persistence.
- Production payment gateway integration.
- Live tournament registration and team management.
- Complete administrator workflows.
- Production deployment and backend availability.

Displayed tournament fees or other demonstration information should not be interpreted as verified commercial offers.

## Future Enhancements

Potential improvements include:

- Real-time turf availability.
- Online turf booking and reservation confirmation.
- Secure payment gateway integration.
- Google Maps integration and location-based search.
- Tournament registration and team management.
- Dedicated administrator dashboard.
- Push notifications and booking reminders.
- User reviews and ratings.
- Booking history and transaction management.
- Improved analytics and reporting.

## Disclaimer

BookMyTurf is developed for academic and educational purposes. The application and its displayed information are intended for demonstration. Availability, pricing, tournament details, authentication, bookings, and payment functionality must be independently verified before any real-world use.

---

**BookMyTurf**

*LESS PLANNING. MORE PLAY.*
