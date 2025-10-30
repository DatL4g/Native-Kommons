package dev.datlag.kommons


data object DemocraticRepublicCongo : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("CD")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("COD")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(180)
}