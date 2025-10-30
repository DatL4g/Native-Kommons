package dev.datlag.kommons


data object NorthernMarianaIslands : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("MP")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("MNP")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(580)
}