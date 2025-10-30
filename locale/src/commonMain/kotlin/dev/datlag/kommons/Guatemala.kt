package dev.datlag.kommons


data object Guatemala : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("GT")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("GTM")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(320)
}