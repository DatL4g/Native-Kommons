package dev.datlag.kommons


data object CostaRica : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("CR")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("CRI")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(188)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(506)
    override val continent: Continent = Continent.NorthAmerica
}