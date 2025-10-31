package dev.datlag.kommons


data object Andorra : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("AD")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("AND")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(20)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(376)
    override val continent: Continent = Continent.Europe
}