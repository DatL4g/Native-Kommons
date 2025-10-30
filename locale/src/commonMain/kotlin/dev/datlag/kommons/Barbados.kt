package dev.datlag.kommons


data object Barbados : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("BB")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("BRB")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(52)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(1246)
}