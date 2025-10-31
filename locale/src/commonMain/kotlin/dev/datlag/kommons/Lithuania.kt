package dev.datlag.kommons


data object Lithuania : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("LT")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("LTU")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(440)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(370)
    override val continent: Continent = Continent.Europe
}