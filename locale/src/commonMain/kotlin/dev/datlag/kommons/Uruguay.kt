package dev.datlag.kommons


data object Uruguay : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("UY")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("URY")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(858)
}