fun lookupPhoneNumber(phoneNumber: String) {
    val apiKey = BuildConfig.PHONE_LOOKUP_API_KEY
    phoneLookupAPI.lookupPhoneNumber(phoneNumber, apiKey)
        .enqueue(object : Callback<PhoneLookupResult> {
            override fun onResponse(call: Call<PhoneLookupResult>, response: Response<PhoneLookupResult>) {
                if (response.isSuccessful) {
                    val result = response.body()
                    // Handle successful response
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<PhoneLookupResult>, t: Throwable) {
                // Handle failure
            }
        })
}
