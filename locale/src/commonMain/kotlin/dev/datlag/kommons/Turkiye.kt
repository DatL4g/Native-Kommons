package dev.datlag.kommons


data object Turkiye : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("TR")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("TUR")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(792)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(90)
}