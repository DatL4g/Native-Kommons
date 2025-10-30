package dev.datlag.kommons


data object Reunion : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("RE")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("REU")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(638)
}