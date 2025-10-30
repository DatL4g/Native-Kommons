package dev.datlag.kommons


data object Kazakhstan : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("KZ")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("KAZ")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(398)
}