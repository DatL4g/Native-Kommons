package dev.datlag.kommons


data object Malawi : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("MW")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("MWI")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(454)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(265)
}