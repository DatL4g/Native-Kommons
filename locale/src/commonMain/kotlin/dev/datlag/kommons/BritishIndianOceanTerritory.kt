package dev.datlag.kommons


data object BritishIndianOceanTerritory : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("IO")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("IOT")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(86)
}