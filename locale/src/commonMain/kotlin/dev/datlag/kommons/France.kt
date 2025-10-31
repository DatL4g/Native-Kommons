package dev.datlag.kommons


data object France : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("FR")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("FRA")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(250)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(33)
    override val continent: Continent = Continent.Europe
}