package dev.datlag.kommons


data object Martinique : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("MQ")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("MTQ")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(474)
}