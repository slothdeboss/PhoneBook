package com.slothdeboss.local.source

import com.slothdeboss.local.entity.LocalContact

internal object PrepopulateSource {

    fun getPrepopulateContacts() = listOf<LocalContact>(
        LocalContact(
            name = "Uncle",
            surname = "Bob",
            imageUrl = "https://www.meme-arsenal.com/memes/ac88e286400ac8176632c22890161a39.jpg",
            email = "UncleBob@example.com"
        ),
        LocalContact(
            name = "Elon",
            surname = "Musk",
            imageUrl = "https://i.insider.com/5ec7e9e03f73704f0e12cb24?width=1100&format=jpeg&auto=webp",
            email = "ElonMusk@example.com"
        ),
        LocalContact(
            name = "Andrey",
            surname = "Breslav",
            imageUrl = "https://pbs.twimg.com/profile_images/858532228275601409/687Zdk1H_400x400.jpg",
            email = "AndreyBreslav@example.com"
        ),
        LocalContact(
            name = "Steve",
            surname = "Jobs",
            imageUrl = "https://www.biography.com/.image/t_share/MTY2MzU3OTcxMTUwODQxNTM1/steve-jobs--david-paul-morrisbloomberg-via-getty-images.jpg",
            email = "SteveJobs@example.com"
        ),
        LocalContact(
            name = "Linus",
            surname = "Torvalds",
            imageUrl = "https://lh3.googleusercontent.com/proxy/G8951U448EbQmzaMgOnDPJDfv-XBA7Y_sckzldd64vO0MzlGXMD_u_9WhXKLg363AOn8FaZOXg-LfKjAGuKnDXIOybV9VnnQliLyULFzasDyhwcU_w4hAsznC-g6klDuRxml6TOezmXucp-iMclNo57q",
            email = "LinusTorvadls@example.com"
        )
    )

}