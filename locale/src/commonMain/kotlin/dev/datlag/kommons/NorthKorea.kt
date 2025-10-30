package dev.datlag.kommons


data object NorthKorea : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("KP")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("PRK")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(408)
}