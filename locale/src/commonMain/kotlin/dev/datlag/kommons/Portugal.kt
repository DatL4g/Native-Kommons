package dev.datlag.kommons


data object Portugal : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("PT")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("PRT")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(620)
}