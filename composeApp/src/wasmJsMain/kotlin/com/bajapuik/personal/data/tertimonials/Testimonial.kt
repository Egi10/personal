package com.bajapuik.personal.data.tertimonials

data class Testimonial(
    val message: String,
    val name: String,
    val role: String,
    val image: String?
)

object TestimonialData {
    val testimonials = listOf(
        Testimonial(
            message = "Egi itu seorang problem-solver juga gigih dalam bekerja. Selalu lebih mendetail saat merancang sesuatu sehingga hasil nya sangat baik. Recommended Mobile Engineer.",
            name = "Wildan Angga Rahman",
            role = "Mobile Engineer",
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSV7rJh13ruHHHOmrbO2mKI7j8cy-lcJ3HTrQ&s"
        )
    )
}