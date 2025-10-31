package dev.datlag.kommons


data object Tunisia : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("TN")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("TUN")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(788)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(216)
    override val continent: Continent = Continent.Africa
}