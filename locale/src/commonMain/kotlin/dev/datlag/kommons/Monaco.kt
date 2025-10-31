package dev.datlag.kommons


data object Monaco : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("MC")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("MCO")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(492)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(377)
    override val continent: Continent = Continent.Europe
}