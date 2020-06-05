package com.slothdeboss.local.source

import com.slothdeboss.local.entity.LocalContact

internal object PrepopulateSource {

    fun getPrepopulateContacts() = listOf<LocalContact>(
        LocalContact(
            name = "Uncle", surname = "Bob",
            imageUrl = "", email = "UncleBob@example.com"
        ),
        LocalContact(
            name = "Elon", surname = "Musk",
            imageUrl = "", email = "@ElonMuskexample.com"
        ),
        LocalContact(
            name = "Andrey", surname = "Breslav",
            imageUrl = "", email = "AndreyBreslav@example.com"
        ),
        LocalContact(
            name = "Steve", surname = "Jobs",
            imageUrl = "", email = "SteveJobs@example.com"
        ),
        LocalContact(
            name = "Linus", surname = "Torvalds",
            imageUrl = "", email = "LinusTorvadls@example.com"
        )
    )

}