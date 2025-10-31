package dev.datlag.kommons


data object BosniaAndHerzegovina : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("BA")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("BIH")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(70)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(387)
    override val continent: Continent = Continent.Europe
}