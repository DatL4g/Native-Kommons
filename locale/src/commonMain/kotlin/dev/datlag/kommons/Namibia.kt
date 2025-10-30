package dev.datlag.kommons


data object Namibia : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("NA")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("NAM")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(516)
}