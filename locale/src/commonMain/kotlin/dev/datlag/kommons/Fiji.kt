package dev.datlag.kommons


data object Fiji : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("FJ")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("FJI")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(242)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(679)
    override val continent: Continent = Continent.Oceania
}