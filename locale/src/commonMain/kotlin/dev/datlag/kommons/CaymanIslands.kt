package dev.datlag.kommons


data object CaymanIslands : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("KY")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("CYM")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(136)
}