# Personal Portfolio

Proyek ini adalah portofolio pribadi berbasis **Kotlin Multiplatform (KMP)** yang menargetkan platform **Web (Wasm)** menggunakan **Compose Multiplatform**. Aplikasi ini dirancang dengan arsitektur modern dan responsif untuk menampilkan informasi profil, pengalaman kerja, proyek (works), keahlian (skills), dan testimoni.

Aplikasi ini dapat diakses secara langsung di [egi10.github.io](https://egi10.github.io/).

## Fitur Utama

*   **Responsive Design**: Mendukung tampilan Mobile, Tablet, dan Desktop menggunakan Material 3 Window Size Class.
*   **Dark & Light Mode**: Tema aplikasi yang dapat menyesuaikan dengan preferensi pengguna.
*   **Modern Architecture**: Menggunakan pola MVVM (Model-View-ViewModel) dengan StateFlow untuk manajemen state yang reaktif.
*   **Dependency Injection**: Memanfaatkan Koin untuk pengelolaan dependensi yang bersih.
*   **Smooth Animations**: Implementasi efek shimmer dan transisi yang halus menggunakan Compose.
*   **Type-Safe Resources**: Pengelolaan resource (string, font, drawable) yang terpusat dan aman.

## Tech Stack

*   **[Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html)**: Bahasa pemrograman utama untuk berbagi logika di berbagai platform.
*   **[Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/)**: Framework UI deklaratif untuk membangun antarmuka pengguna.
*   **[Kotlin/Wasm](https://kotlinlang.org/docs/wasm-overview.html)**: Target kompilasi ke WebAssembly untuk performa tinggi di web.
*   **[Ktor Client](https://ktor.io/)**: Library networking untuk mengambil data dari API/Remote Source.
*   **[Koin](https://insert-koin.io/)**: Framework Dependency Injection (DI).
*   **[Coil 3](https://coil-kt.github.io/coil/)**: Library loading gambar secara asinkron dengan dukungan KMP.
*   **[Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization)**: Untuk parsing data JSON secara type-safe.
*   **[Multiplatform Settings](https://github.com/russhwolf/multiplatform-settings)**: Penyimpanan lokal key-value untuk preferensi pengguna (seperti tema).
*   **[Jetpack Lifecycle (ViewModel)](https://developer.android.com/topic/libraries/architecture/viewmodel)**: Manajemen state UI yang terintegrasi dengan siklus hidup komponen.

## Struktur Proyek

*   `composeApp`: Modul utama aplikasi.
    *   `src/wasmJsMain`: Kode khusus untuk target platform WebAssembly.
    *   `src/commonMain`: Kode bersama (Resources, Logic, Models) yang bisa digunakan antar platform.
*   `di`: Konfigurasi Dependency Injection (Network, Repository, ViewModel, DataSource).
*   `domain`: Business logic, interface repository, dan model data utama.
*   `data`: Implementasi repository, data sources (Remote & Local), dan mapper.
*   `screen`: UI layer yang terbagi menjadi beberapa fitur (Home, Root) dengan masing-masing ViewModel dan UI state.

## Menjalankan Aplikasi

Pastikan Anda telah menginstal JDK 17 atau yang lebih baru.

### Development Mode
Untuk menjalankan aplikasi secara lokal dengan fitur *hot reload*:

```bash
./gradlew wasmJsBrowserDevelopmentRun -t
```

### Build for Production
Untuk membangun file produksi yang siap di-deploy:

```bash
./gradlew wasmJsBrowserDistribution
```
Hasil build akan tersedia di direktori `composeApp/build/dist/wasmJs/productionExecutable`.

## Konfigurasi Penting

Jika Anda mengalami error `java.lang.ArrayIndexOutOfBoundsException` saat kompilasi Wasm, pastikan opsi berikut ada di `gradle.properties`:

```properties
kotlin.incremental.wasm=false
```

## Kontribusi

Kontribusi sangat terbuka! Jika Anda menemukan bug, memiliki ide fitur baru, atau ingin memperbaiki dokumentasi:
1. Fork repositori ini.
2. Buat branch fitur baru (`git checkout -b fitur-baru`).
3. Commit perubahan Anda (`git commit -m 'Menambahkan fitur baru'`).
4. Push ke branch tersebut (`git push origin fitur-baru`).
5. Buat Pull Request.

---
Dibuat dengan ❤️ menggunakan Kotlin Multiplatform.
