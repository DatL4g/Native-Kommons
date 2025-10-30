package dev.datlag.kommons


data object Paraguay : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("PY")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("PRY")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(600)
}