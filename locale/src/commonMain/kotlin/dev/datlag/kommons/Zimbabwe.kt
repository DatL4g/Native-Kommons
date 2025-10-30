package dev.datlag.kommons


data object Zimbabwe : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("ZW")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("ZWE")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(716)
}