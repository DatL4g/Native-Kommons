package dev.datlag.kommons


data object Jamaica : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("JM")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("JAM")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(388)
}