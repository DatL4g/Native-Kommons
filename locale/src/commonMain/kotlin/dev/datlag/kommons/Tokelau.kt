package dev.datlag.kommons


data object Tokelau : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("TK")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("TKL")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(772)
}