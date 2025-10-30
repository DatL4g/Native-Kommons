package dev.datlag.kommons


data object Antarctica : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("AQ")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("ATA")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(10)
}