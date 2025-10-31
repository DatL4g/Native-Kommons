package dev.datlag.kommons


data object Montenegro : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("ME")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("MNE")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(499)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(382)
    override val continent: Continent = Continent.Europe
}