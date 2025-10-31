package dev.datlag.kommons


data object Djibouti : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("DJ")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("DJI")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(262)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(253)
    override val continent: Continent = Continent.Africa
}