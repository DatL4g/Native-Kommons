package dev.datlag.kommons


data object NewZealand : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("NZ")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("NZL")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(554)
}