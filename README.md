# Personal Portfolio

Proyek ini adalah portofolio dalam bentuk aplikasi berbasis **Kotlin Multiplatform** yang menargetkan platform **web** menggunakan **Compose Multiplatform**. Aplikasi ini dirancang untuk mendukung dan ditampilkan di [egi10.github.io](https://egi10.github.io/).

## Menjalankan Aplikasi

Untuk menjalankan aplikasi secara lokal, gunakan perintah berikut:

```bash
./gradlew wasmJsBrowserDevelopmentRun -t
```

Untuk panduan yang lebih lengkap, silakan lihat dokumentasi resmi Kotlin: [Run the application – Kotlin/Wasm](https://kotlinlang.org/docs/wasm-get-started.html#run-the-application)

## Tech Stack

* [Kotlin Multiplatform](https://kotlinlang.org/docs/multiplatform.html)
* [Compose Multiplatform](https://www.jetbrains.com/lp/compose-multiplatform/)
* [Ktor](https://ktor.io/) – Client untuk komunikasi jaringan
* [Koin](https://insert-koin.io/) – Dependency injection
* [Coil](https://coil-kt.github.io/coil/) – Image loading
* [Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization) – JSON parsing
* [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) – Asynchronous programming
* [Kotlin/Wasm](https://kotlinlang.org/docs/wasm-overview.html) – Untuk menargetkan WebAssembly

## Kontribusi

Kontribusi sangat terbuka! Jika Anda menemukan bug, memiliki ide fitur baru, atau ingin memperbaiki dokumentasi, jangan ragu untuk membuat *issue* atau kirimkan *pull request*. Setiap kontribusi sangat kami hargai dalam pengembangan proyek ini.
