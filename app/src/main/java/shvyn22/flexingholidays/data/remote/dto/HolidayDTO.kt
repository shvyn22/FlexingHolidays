package shvyn22.flexingholidays.data.remote.dto

import com.google.gson.annotations.SerializedName

data class HolidayDTO(
	@SerializedName("uuid")
	val uuid: String,

	@SerializedName("name")
	val name: String,

	@SerializedName("date")
	val date: String,

	@SerializedName("public")
	val isPublic: Boolean,

	@SerializedName("country")
	val country: String
)