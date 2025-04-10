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
        ),
        Testimonial(
            message = "Julsaparigi have a great insting as logical roles, he can balance beetween feels and logic to connected with my design and deliver the smooth interaction using his code",
            name = "Permana Handiyuda",
            role = "Interactin Designer II",
            image = "https://framerusercontent.com/images/APE9IHS2cgALQ3CPofVr9lmqnc.png?scale-down-to=512"
        ),
        Testimonial(
            message = "Egi sangat berdedikasi dengan dunia mobile engineering, tiap tantangan dia jawab dengan sungguh sungguh, hasil karyanya mulai dari refactor KMP hingga jetpack compose membuat codebase kita modern dan baik sehingga minim error dan mampu mendeliver features dengan baik.",
            name = "Mohamad Damba Putrabangga",
            role = "Senior Engineering Manager",
            image = "https://media.licdn.com/dms/image/v2/C5603AQES8LPrXNquMw/profile-displayphoto-shrink_800_800/profile-displayphoto-shrink_800_800/0/1517436250905?e=1749686400&v=beta&t=2tlXl3HkGldHSU8dp7M1FG6ZTpO4JPYCgCLsPvtxRcE"
        )
    )
}