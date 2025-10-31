package dev.datlag.kommons


data object Indonesia : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("ID")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("IDN")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(360)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(62)
    override val continent: Continent = Continent.Asia
}