package com.example.countrypedia.data.remote.dto

import com.example.countrypedia.domain.model.Country

data class CountryDTO(val CountryDTO : ArrayList<CountryDTOElement>)

fun CountryDTO.toCountryList(): List<Country>{
    return CountryDTO.map {
            countryDTOElement -> Country(countryName = countryDTOElement.name.common,flag = countryDTOElement.flag)
    }
}

data class CountryDTOElement (
    val name: Name,
    val tld: List<String>? = null,
    val cca2: String,
    val ccn3: String? = null,
    val cca3: String,
    val independent: Boolean? = null,
    val status: Status,
    val unMember: Boolean,
    val currencies: Currencies? = null,
    val idd: Idd,
    val capital: List<String>? = null,
    val altSpellings: List<String>,
    val region: Region,
    val subregion: String? = null,
    val languages: Map<String, String>? = null,
    val translations: Map<String, Translation>,
    val latlng: List<Double>,
    val landlocked: Boolean,
    val area: Double,
    val demonyms: Demonyms? = null,
    val flag: String,
    val maps: Maps,
    val population: Long,
    val car: Car,
    val timezones: List<String>,
    val continents: List<Continent>,
    val flags: Flags,
    val coatOfArms: CoatOfArms,
    val startOfWeek: StartOfWeek,
    val capitalInfo: CapitalInfo,
    val postalCode: PostalCode? = null,
    val cioc: String? = null,
    val borders: List<String>? = null,
    val fifa: String? = null,
    val gini: Map<String, Double>? = null
)

data class CapitalInfo (
    val latlng: List<Double>? = null
)

data class Car (
    val signs: List<String>? = null,
    val side: Side
)

enum class Side {
    Left,
    Right
}

data class CoatOfArms (
    val png: String? = null,
    val svg: String? = null
)

enum class Continent {
    Africa,
    Antarctica,
    Asia,
    Europe,
    NorthAmerica,
    Oceania,
    SouthAmerica
}

data class Currencies (
    val aud: Aed? = null,
    val ern: Aed? = null,
    val wst: Aed? = null,
    val mkd: Aed? = null,
    val djf: Aed? = null,
    val jod: Aed? = null,
    val pkr: Aed? = null,
    val xpf: Aed? = null,
    val eur: Aed? = null,
    val mru: Aed? = null,
    val dkk: Aed? = null,
    val nad: Aed? = null,
    val zar: Aed? = null,
    val ghs: Aed? = null,
    val ssp: Aed? = null,
    val usd: Aed? = null,
    val mdl: Aed? = null,
    val kpw: Aed? = null,
    val mop: Aed? = null,
    val scr: Aed? = null,
    val amd: Aed? = null,
    val ang: Aed? = null,
    val xaf: Aed? = null,
    val syp: Aed? = null,
    val aoa: Aed? = null,
    val tjs: Aed? = null,
    val ves: Aed? = null,
    val pln: Aed? = null,
    val sar: Aed? = null,
    val bam: BAM? = null,
    val czk: Aed? = null,
    val gtq: Aed? = null,
    val krw: Aed? = null,
    val npr: Aed? = null,
    val bwp: Aed? = null,
    val php: Aed? = null,
    val iqd: Aed? = null,
    val lbp: Aed? = null,
    val bif: Aed? = null,
    val mnt: Aed? = null,
    val fok: Aed? = null,
    val pyg: Aed? = null,
    val nok: Aed? = null,
    val nzd: Aed? = null,
    val gbp: Aed? = null,
    val ggp: Aed? = null,
    val dzd: Aed? = null,
    val pab: Aed? = null,
    val egp: Aed? = null,
    val ils: Aed? = null,
    val yer: Aed? = null,
    val brl: Aed? = null,
    val ngn: Aed? = null,
    val jpy: Aed? = null,
    val tzs: Aed? = null,
    val kzt: Aed? = null,
    val shp: Aed? = null,
    val lkr: Aed? = null,
    val mad: Aed? = null,
    val mmk: Aed? = null,
    val cop: Aed? = null,
    val pen: Aed? = null,
    val xof: Aed? = null,
    val kgs: Aed? = null,
    val cny: Aed? = null,
    val afn: Aed? = null,
    val currenciesTRY: Aed? = null,
    val lrd: Aed? = null,
    val clp: Aed? = null,
    val kid: Aed? = null,
    val cve: Aed? = null,
    val jep: Aed? = null,
    val isk: Aed? = null,
    val gmd: Aed? = null,
    val vuv: Aed? = null,
    val uyu: Aed? = null,
    val omr: Aed? = null,
    val sdg: BAM? = null,
    val inr: Aed? = null,
    val lak: Aed? = null,
    val awg: Aed? = null,
    val kmf: Aed? = null,
    val xcd: Aed? = null,
    val uzs: Aed? = null,
    val mvr: Aed? = null,
    val gip: Aed? = null,
    val idr: Aed? = null,
    val vnd: Aed? = null,
    val myr: Aed? = null,
    val ckd: Aed? = null,
    val szl: Aed? = null,
    val ugx: Aed? = null,
    val mga: Aed? = null,
    val fjd: Aed? = null,
    val twd: Aed? = null,
    val pgk: Aed? = null,
    val rwf: Aed? = null,
    val cdf: Aed? = null,
    val rsd: Aed? = null,
    val khr: Aed? = null,
    val aed: Aed? = null,
    val bmd: Aed? = null,
    val cuc: Aed? = null,
    val cup: Aed? = null,
    val hkd: Aed? = null,
    val mur: Aed? = null,
    val ars: Aed? = null,
    val nio: Aed? = null,
    val uah: Aed? = null,
    val gyd: Aed? = null,
    val tvd: Aed? = null,
    val lsl: Aed? = null,
    val top: Aed? = null,
    val gel: Aed? = null,
    val etb: Aed? = null,
    val dop: Aed? = null,
    val bzd: Aed? = null,
    val imp: Aed? = null,
    val htg: Aed? = null,
    val bdt: Aed? = null,
    val kwd: Aed? = null,
    val jmd: Aed? = null,
    val ron: Aed? = null,
    val stn: Aed? = null,
    val bsd: Aed? = null,
    val mxn: Aed? = null,
    val tmt: Aed? = null,
    val srd: Aed? = null,
    val sek: Aed? = null,
    val bob: Aed? = null,
    val mzn: Aed? = null,
    val mwk: Aed? = null,
    val all: Aed? = null,
    val zmw: Aed? = null,
    val chf: Aed? = null,
    val qar: Aed? = null,
    val sbd: Aed? = null,
    val lyd: Aed? = null,
    val bbd: Aed? = null,
    val hnl: Aed? = null,
    val sos: Aed? = null,
    val kyd: Aed? = null,
    val kes: Aed? = null,
    val bhd: Aed? = null,
    val gnf: Aed? = null,
    val rub: Aed? = null,
    val bnd: Aed? = null,
    val sgd: Aed? = null,
    val zwl: Aed? = null,
    val byn: Aed? = null,
    val thb: Aed? = null,
    val tnd: Aed? = null,
    val sll: Aed? = null,
    val btn: Aed? = null,
    val fkp: Aed? = null,
    val cad: Aed? = null,
    val ttd: Aed? = null,
    val huf: Aed? = null,
    val crc: Aed? = null,
    val bgn: Aed? = null,
    val azn: Aed? = null,
    val irr: Aed? = null
)

data class Aed (
    val name: String,
    val symbol: String
)

data class BAM (
    val name: String
)

data class Demonyms (
    val eng: Eng,
    val fra: Eng? = null
)

data class Eng (
    val f: String,
    val m: String
)

data class Flags (
    val png: String,
    val svg: String,
    val alt: String? = null
)

data class Idd (
    val root: String? = null,
    val suffixes: List<String>? = null
)

data class Maps (
    val googleMaps: String,
    val openStreetMaps: String
)

data class Name (
    val common: String,
    val official: String,
    val nativeName: Map<String, Translation>? = null
)

data class Translation (
    val official: String,
    val common: String
)

data class PostalCode (
    val format: String,
    val regex: String? = null
)

enum class Region {
    Africa,
    Americas,
    Antarctic,
    Asia,
    Europe,
    Oceania
}

enum class StartOfWeek {
    Monday,
    Saturday,
    Sunday
}

enum class Status {
    OfficiallyAssigned,
    UserAssigned
}