package dev.datlag.kommons


data object AlandIslands : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("AX")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("ALA")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(248)
}