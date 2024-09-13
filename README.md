# News Application

An Android application that allows users to search for news articles from a public API, view article details, and access previously viewed articles even when offline. This app utilizes caching to enable offline access to articles that the user has already viewed.

## Features

- **Search for News Articles**: Users can search for news articles using keywords.
- **View Article Details**: Detailed information about a selected article is displayed.
- **Offline Access**: Articles that the user has previously viewed are cached and available offline.

## Tech Stack

- **Programming Language**: Kotlin
- **Architecture**: MVVM (Model-View-ViewModel)
- **API**: NewsAPI (api key can be found at https://newsapi.org)
- **Caching**: Room Database (for offline support)
- **Networking**: KTOR
- **Dependency Injection**: Koin



## Requirements

- **Android Studio**: Ensure you have Android Studio installed.
- **API Key**: Obtain an API key from [NewsAPI](https://newsapi.org/).

### How to Obtain the API Key

1. Visit [NewsAPI](https://newsapi.org/) and sign up for a free account.
2. After signing up, generate your API key.
3. This API key will be needed to fetch news articles.

## Project Setup

### Clone the Repository

```bash
git clone <your-repository-url>
cd <your-repository-directory>
