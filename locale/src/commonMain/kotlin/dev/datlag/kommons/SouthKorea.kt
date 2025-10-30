package dev.datlag.kommons


data object SouthKorea : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("KR")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("KOR")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(410)
}