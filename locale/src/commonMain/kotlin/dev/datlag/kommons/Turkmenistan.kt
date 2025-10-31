package dev.datlag.kommons


data object Turkmenistan : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("TM")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("TKM")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(795)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(993)
    override val continent: Continent = Continent.Asia
}